package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SucursalAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.OrganizacionRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarInformacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AccesoVIP;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Actuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ActuarioList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTipoSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoCompletoRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoDigitalAforeSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentosRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativaList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Genero;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GiroNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GiroNegocioList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GradoEstudios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GradoEstudiosList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Icefa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ModuloReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MunicipiosList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NacionalidadesList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarMunicipio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Ocupacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.OcupacionList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Pais;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PaisList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parentesco;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParentescoList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoDoctoProbatorio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoDoctoProbatorioList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProcesoExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * interfaz para el manejo de la organizacion
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Service
public class CatalogoServiceImpl implements CatalogoService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CatalogoServiceImpl.class);

	/**
	 * Inyeccion Servicio afores
	 */
	@Value("${validacion.afore.activo}")
	private String servicioAfores;

	/**
	 * Inyeccion Servicio Parametro
	 */
	@Value("${validacion.parametro.lista}")
	private String servicioParametro;

	/**
	 * Inyeccion Servicio icefa
	 */
	@Value("${validacion.lista.icefa}")
	private String servicioIcefa;

	/**
	 * Inyeccion de servicio tipo solicitante
	 */
	@Value("${validacion.tipo.solicitante}")
	private String servicioSolicitante;

	/**
	 * Iyeccion servicio nacionalidad
	 */
	@Value("${comunes.nacionalidad.consultar}")
	private String servicioNacionalidad;

	/**
	 * Inyeccion servicioCatalogo
	 */
	@Value("${url.obtenerInfo.catalogo}")
	private String servicioCatalogo;

	/**
	 * Cliente
	 */
	@Autowired
	private RestTemplate servicioCliente;

	/**
	 * dependencia utilidad validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * dependencia utilidad cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;

	/**
	 * Inyeccion de servicio Guardar
	 */
	@Autowired
	private GuardarInformacionService servicioGuardar;

	/**
	 * Inyeccion repositorio Organizacion
	 */
	@Autowired
	private OrganizacionRepository repositorioOrganizacion;

	/**
	 * Iyeccion servicio tipo documento digital
	 */
	@Value("${comunes.tipo.documento}")
	private String servicioTipoDocumento;

	/**
	 * Inyeccion servicioSubDocumentos
	 */
	@Value("${comunes.documentos.consultar}")
	private String servicioSubDocumentos;

	/**
	 * Inyeccion servicioSucursales
	 */
	@Value("${validacion.sucursales.afore}")
	private String servicioSucursales;

	/**
	 * recuperacion de entidad federativa
	 */
	@Value("${validacion.entidad.claveCorta}")
	private String consultarEntidad;

	/**
	 * Inyeccion propiedad para consulta codigo postal
	 */
	@Value("${consulta.codigo.postal}")
	private String consultaCodigoPostal;

	/**
	 * Inyeccion propiedad para consulta documentos requeridos
	 */
	@Value("${consultar.documentos.requeridos}")
	private String consultaDocumentosRequeridos;

	/**
	 * Atributo consultaGeneros
	 */
	@Value("${url.consulta.obtener.catalogo.generos}")
	private String consultaGeneros;

	/**
	 * Atributo consultaEntidadFederativa
	 */
	@Value("${url.consulta.obtener.catalogo.entidad.federativa}")
	private String consultaEntidadFederativa;

	/**
	 * Atributo consultaTipoProceso
	 */
	@Value("${url.consulta.obtener.tipo.proceso.expediente}")
	private String consultaTipoProceso;

	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * restServiceClientUtils
	 */
	@Autowired
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Afore> obtenerAfores() {
		logger.info("Se obtiene la lista de afores activas");
		List<Afore> afores = null;
		try {
			String respuestaAfore = servicioCliente.getForObject(servicioAfores, String.class);

			if (!utileriaValidador.validarVacio(respuestaAfore)) {
				JsonUtilsImpl<Afore> utileriaJson = new JsonUtilsImpl<>();
				afores = utileriaJson.parseJsonToObjectList(respuestaAfore, Afore.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en el servicio de obtener afores", e);
		}
		return afores;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Parametro> obtenerParametro(String clave, String desc) {
		logger.info("Se obtiene lista de parametro");
		List<Parametro> parametro = null;
		try {
			String urlParametro = utileriaCadena.obtenerCadenaConcatenada(true, servicioParametro, clave);
			if (!utileriaValidador.validarVacio(desc)) {
				urlParametro = utileriaCadena.obtenerCadenaConcatenada(true, urlParametro,
						ExpresionesConstants.DIAGONAL, desc, ExpresionesConstants.DIAGONAL);
			}
			
			logger.error("URL Parametro: {}",urlParametro);
			String respuestaParametro = servicioCliente.getForObject(urlParametro, String.class);
			if (!utileriaValidador.validarVacio(respuestaParametro)) {
				JsonUtilsImpl<Parametro> utileriaJson = new JsonUtilsImpl<>();
				parametro = utileriaJson.parseJsonToObjectList(respuestaParametro, Parametro.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado obtener parametro", e);
		}
		
		logger.error("Se obtiene parametro: {}", parametro);
		return parametro;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Icefa> obtenerIcefa(String clave) {
		logger.info("Se obtiene lista de String de icefas");
		List<Icefa> respuesta = null;
		try {
			String urlParametro = utileriaCadena.obtenerCadenaConcatenada(true, servicioIcefa, clave);
			String respuestaServicio = servicioCliente.getForObject(urlParametro, String.class);

			if (!utileriaValidador.validarVacio(respuestaServicio)) {
				JsonUtilsImpl<Icefa> utileriaJson = new JsonUtilsImpl<>();
				respuesta = utileriaJson.parseJsonToObjectList(respuestaServicio, Icefa.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en el servicio de obtener Icefa", e);
		}
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio obtenerRespuesta(DatosRegistro registro, String codigo, String claveAfore, Integer flujo,
			String minutos) {
		logger.info("Se obtiene la respuesta del codigo {} {}", codigo, claveAfore);
		return servicioGuardar.guardarRechazoUsuario(registro, codigo, claveAfore, flujo, minutos);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Organizacion> obtenerOrganizaciones() {
		logger.info("Se obtiene la lista de organizaciones activas");
		List<Organizacion> organizacion = null;
		try {
			organizacion = repositorioOrganizacion.findAll();
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener organizaciones", e);
		}
		return organizacion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nacionalidad obtenerNacionalidad(Long idNacionalidad) {
		logger.info("Se obtiene datos de ancionalidad");
		Nacionalidad nacionalidad = null;
		try {
			String urlNacionalidad = utileriaCadena.obtenerCadenaConcatenada(true, servicioNacionalidad,
					String.valueOf(idNacionalidad));
			nacionalidad = servicioCliente.getForObject(urlNacionalidad, Nacionalidad.class);
		} catch (Exception e) {
			logger.error(ServiciosConstants.LOG_NACIONALIDADES, e);
		}
		return nacionalidad;
	}

	/**
	 * Metodo encargado de obtener datos de Parametro
	 * 
	 * @param claveParametro
	 * @return
	 */
	@Override
	public List<Parametro> obtenerParametroDdbpose(String claveParametro) {
		ParametroList listaParametro = null;
		try {

			listaParametro = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_PARAMETRO_DDBPOSE).append(claveParametro)
					.toString(), ParametroList.class);

			logger.info(String.format("Se encontraron %d parametros!",
					listaParametro != null ? listaParametro.getListaParametros().size() : "'indefinido'"));
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Parametros DDBOPOSE URL Service {}",
					new StringBuilder(servicioCatalogo).append(claveParametro).toString(), e);
		}
		return listaParametro.getListaParametros();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Parametro> obtenerParametroDdbpose(final String claveParametro, final String descripcionParametro) {

		List<Parametro> parametrosConsultados = obtenerParametroDdbpose(claveParametro);

		// En caso de que no se genere una instancia de la lista genera una.
		if (utileriaValidador.validarObjetoNulo(parametrosConsultados)) {
			return new ArrayList<>();
		}

		// Filtrado por descripción una lista simulando la programción funcional de java
		// 8.
		return Lists.newArrayList(Iterables.filter(parametrosConsultados, new Predicate<Parametro>() {

			@Override
			public boolean apply(Parametro parametro) {
				return StringUtils.equals(parametro.getChParametro(), descripcionParametro);
			}
		}));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerNacionalidades()
	 */
	@Override
	public List<Nacionalidad> obtenerNacionalidades() {
		NacionalidadesList listaNacionalidades = null;
		List<Nacionalidad> lista = null;
		try {
			listaNacionalidades = servicioCliente
					.getForObject(
							new StringBuilder(servicioCatalogo)
									.append(ModificacionTrabajadorConstants.SERVICIO_NACIONALIDADES).toString(),
							NacionalidadesList.class);
			logger.info("NACIONALIDADES: {}", listaNacionalidades);
			if (!utileriaValidador.validarObjetoNulo(listaNacionalidades)) {
				lista = listaNacionalidades.getListaNacionalidades();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Nacionalidades URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BiomTipoSolicitante> obtenerTipoSolicitante(String claveSolicitante) {
		logger.info("Se obtiene la lista de tipo solicitante");
		List<BiomTipoSolicitante> listasolicitante = null;
		try {
			String urlSolicitante = utileriaCadena.obtenerCadenaConcatenada(true, servicioSolicitante,
					claveSolicitante);
			String respuestaSolicitante = servicioCliente.getForObject(urlSolicitante, String.class);

			if (!utileriaValidador.validarVacio(respuestaSolicitante)) {
				JsonUtilsImpl<BiomTipoSolicitante> utileriaJson = new JsonUtilsImpl<>();
				listasolicitante = utileriaJson.parseJsonToObjectList(respuestaSolicitante, BiomTipoSolicitante.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener tipo solicitante", e);
		}
		return listasolicitante;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DocumentoCompletoRequerido> obtenerTipoDocumento(String claveTipoProceso) {
		logger.info("Se obtiene la lista de tipo documento completo");
		List<DocumentoCompletoRequerido> listaDocumentos = null;
		try {
			String urlDocumentos = utileriaCadena.obtenerCadenaConcatenada(true, servicioTipoDocumento,
					claveTipoProceso);
			String respuestaDocumentos = servicioCliente.getForObject(urlDocumentos, String.class);

			if (!utileriaValidador.validarVacio(respuestaDocumentos)) {
				JsonUtilsImpl<DocumentoCompletoRequerido> utileriaJson = new JsonUtilsImpl<>();
				listaDocumentos = utileriaJson.parseJsonToObjectList(respuestaDocumentos,
						DocumentoCompletoRequerido.class);
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener tipo documento", e);
		}
		return listaDocumentos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerTiposDoctos()
	 */
	@Override
	public List<TipoDoctoProbatorio> obtenerTiposDoctos() {
		TipoDoctoProbatorioList listaTiposDoctos = null;
		List<TipoDoctoProbatorio> lista = null;
		try {
			listaTiposDoctos = servicioCliente
					.getForObject(
							new StringBuilder(servicioCatalogo)
									.append(ModificacionTrabajadorConstants.SERVICIO_TIPODOCTO).toString(),
							TipoDoctoProbatorioList.class);
			logger.error("doctos::::: {}", listaTiposDoctos);
			if (!utileriaValidador.validarObjetoNulo(listaTiposDoctos)) {
				lista = listaTiposDoctos.getListaTipoDocto();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Tipos de Dcotos URL Service {}", servicioCatalogo, e);
		}
		
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerOcupaciones()
	 */
	@Override
	public List<Ocupacion> obtenerOcupaciones() {
		OcupacionList listaOcupaciones = null;
		List<Ocupacion> lista = null;
		try {
			listaOcupaciones = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_OCUPACIONES).toString(), OcupacionList.class);
			logger.error("Ocupaciones::::: {}", listaOcupaciones);
			if (!utileriaValidador.validarObjetoNulo(listaOcupaciones)) {
				lista = listaOcupaciones.getListaOcupaciones();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Ocupaciones URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerGirosNegocios()
	 */
	@Override
	public List<GiroNegocio> obtenerGirosNegocios() {
		GiroNegocioList listaGiros = null;
		List<GiroNegocio> lista = null;
		try {
			listaGiros = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_GIRO).toString(), GiroNegocioList.class);
			logger.error("Giros/Negocios::::: {}", listaGiros);
			if (!utileriaValidador.validarObjetoNulo(listaGiros)) {
				lista = listaGiros.getListaGiro();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Giros URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerGradoEstudios()
	 */
	@Override
	public List<GradoEstudios> obtenerGradoEstudios() {
		GradoEstudiosList listaGrados = null;
		List<GradoEstudios> lista = null;
		try {
			listaGrados = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_GRADOS).toString(), GradoEstudiosList.class);
			logger.error("Giros/Negocios::::: {}", listaGrados);
			if (!utileriaValidador.validarObjetoNulo(listaGrados)) {
				lista = listaGrados.getListaGrados();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Grados de Estudio URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerPaises()
	 */
	@Override
	public List<Pais> obtenerPaises() {
		PaisList listaPaises = null;
		List<Pais> lista = null;
		try {
			listaPaises = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_PAISES).toString(), PaisList.class);
			logger.error("Paises::::: {}", listaPaises);
			if (!utileriaValidador.validarObjetoNulo(listaPaises)) {
				lista = listaPaises.getListaPaises();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Paises URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerMunicipios()
	 */
	@Override
	public List<NsarMunicipio> obtenerMunicipios() {
		MunicipiosList listaMunicipios = null;
		List<NsarMunicipio> lista = null;
		try {
			listaMunicipios = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_MUNICIPIOS).toString(), MunicipiosList.class);
			logger.error("Municipios::::: {}", listaMunicipios);
			if (!utileriaValidador.validarObjetoNulo(listaMunicipios)) {
				lista = listaMunicipios.getListaMunicipios();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Municipios URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerParentescos()
	 */
	@Override
	public List<Parentesco> obtenerParentescos() {
		ParentescoList listaParentescos = null;
		List<Parentesco> lista = null;
		try {
			listaParentescos = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_PARENTESCO).toString(), ParentescoList.class);
			logger.error("Parentescos::::: {}", listaParentescos);
			if (!utileriaValidador.validarObjetoNulo(listaParentescos)) {
				lista = listaParentescos.getListaParentesco();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Parentescos URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/**
	 * Metodo encargado de obtener datos de entidad federativa
	 * 
	 * @param claveCorta
	 * @return
	 */
	@Override
	public List<EntidadFederativa> obtenerEntidades() {
		EntidadFederativaList entidades = null;
		List<EntidadFederativa> lista = null;
		try {
			entidades = servicioCliente
					.getForObject(
							new StringBuilder(servicioCatalogo)
									.append(ModificacionTrabajadorConstants.SERVICIO_ENTIDADES).toString(),
							EntidadFederativaList.class);
			logger.error("ENTIDADES::::: {}", entidades);
			if (!utileriaValidador.validarObjetoNulo(entidades)) {
				lista = entidades.getEntidadesFederativas();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar entidades federativas URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/**
	 * Metodo encargado de obtener datos de entidad federativa por claveEntidad
	 */
	@Override
	public EntidadFederativa obtenerEntidadFederativa(String claveEntidadFederativa) {
		EntidadFederativa salida = null;
		try {
			String url = utileriaCadena.obtenerCadenaConcatenada(true, servicioCatalogo,
					ModificacionTrabajadorConstants.SERVICIO_ENTIDAD_POR_CLAVE, claveEntidadFederativa);
			logger.info("URL catalogo entidad federativa: {}", url);
			salida = servicioCliente.getForObject(url, EntidadFederativa.class);
		} catch (Exception e) {
			salida = new EntidadFederativa();
			logger.error("Error obtenerEntidadFederativa por clave", e);
		}
		return salida;
	}

	/**
	 * Metodo encargado de obtener datos de entidad federativa por claveCorta
	 * 
	 * @param claveCorta
	 * @return
	 */
	@Override
	public EntidadFederativa obtenerEntidad(String claveCorta) {
		EntidadFederativa entidad = null;
		logger.info("Se obtienen datos de entidad federativa {}", claveCorta);
		try {
			String urlEntidad = utileriaCadena.obtenerCadenaConcatenada(true, consultarEntidad, claveCorta);
			entidad = servicioCliente.getForObject(urlEntidad, EntidadFederativa.class);
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar la entidad {}", claveCorta, e);
		}
		return entidad;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nacionalidad obtenerNacionalidadPorClave(String cvNacionalidad) {
		logger.info("Se obtiene datos de nacionalidad: {}", cvNacionalidad);
		Nacionalidad nacionalidad = null;
		try {
			nacionalidad = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_NACIONALIDAD).append(cvNacionalidad).toString(),
					Nacionalidad.class);
			logger.info("Respuesta nacionalidad: {}", nacionalidad);
		} catch (Exception e) {
			logger.error(ServiciosConstants.LOG_NACIONALIDADES, e);
		}
		return nacionalidad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerMunicipios()
	 */
	@Override
	public List<NsarMunicipio> obtenerMunicipiosPorEntidad(String claveEntidad) {
		MunicipiosList listaMunicipios = null;
		List<NsarMunicipio> lista = null;
		try {
			listaMunicipios = servicioCliente.getForObject(new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.MUNICIPIOS_POR_ENTIDAD).append(claveEntidad).toString(),
					MunicipiosList.class);
			logger.error("Municipios::::: {}", listaMunicipios);
			if (!utileriaValidador.validarObjetoNulo(listaMunicipios)) {
				lista = listaMunicipios.getListaMunicipios();
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Municipios URL Service {}", servicioCatalogo, e);
		}
		return lista;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocumentoDigitalAforeSalida obtenerSubDocumentos(String claveAfore, String claveDocumento) {
		logger.info("Se obtiene datos de subDocumentos");
		DocumentoDigitalAforeSalida documento = null;
		try {
			String urlSubDocumentos = utileriaCadena.obtenerCadenaConcatenada(true, servicioSubDocumentos, claveAfore,
					ExpresionesConstants.DIAGONAL, claveDocumento, ExpresionesConstants.DIAGONAL);
			String respuesta = servicioCliente.getForObject(urlSubDocumentos, String.class);
			JsonUtilsImpl<DocumentoDigitalAforeSalida> metodo = new JsonUtilsImpl<>();
			documento = metodo.parseJsonToObject(respuesta, DocumentoDigitalAforeSalida.class);
		} catch (Exception e) {
			logger.error("Se presento un problema al consulta los subdocumentos", e);
		}
		return documento;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<SucursalAfore> obtenerSucursales(String claveAfore) {

		List<SucursalAfore> listaDocumentos = null;
		try {
			String urlDocumentos = utileriaCadena.obtenerCadenaConcatenada(true, servicioSucursales, claveAfore);
			String respuestaDocumentos = servicioCliente.getForObject(urlDocumentos, String.class);
			if (!utileriaValidador.validarVacio(respuestaDocumentos)) {
				JsonUtilsImpl<SucursalAfore> utileriaJson = new JsonUtilsImpl<>();
				listaDocumentos = utileriaJson.parseJsonToObjectList(respuestaDocumentos, SucursalAfore.class);
				// Se quita la clave sucursal
				for (SucursalAfore sucursalAfore : listaDocumentos) {
					String claveSucursal = sucursalAfore.getClaveEstablecimiento()
							.substring(NumerosConstants.INT_CUATRO, sucursalAfore.getClaveEstablecimiento().length());
					sucursalAfore.setClaveSucursal(claveSucursal);
				}
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener sucursales", e);
		}
		return listaDocumentos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerRedireccionAfore(String claveAfore) {
		List<Parametro> lparametro = this.obtenerParametro(AgenteConstants.PARAMETRO_REDIRECCION, claveAfore);

		return utileriaValidador.obtenerValorParametro(lparametro, claveAfore, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalidaCatalogoCodigoPostal consultarCatalogoCodigoPostal(EntradaCatalogoCodigoPostal entrada) {
		logger.error("Entrada busqueda codigo postal :: {}", entrada);
		SalidaCatalogoCodigoPostal salida = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EntradaCatalogoCodigoPostal> entity = new HttpEntity<>(entrada, headers);

		logger.error("Url consulta codigo postal {}", consultaCodigoPostal);
		try {
			HttpEntity<SalidaCatalogoCodigoPostal> respuesta = servicioCliente.exchange(consultaCodigoPostal,
					HttpMethod.POST, entity, SalidaCatalogoCodigoPostal.class);
			logger.error("Respuesta servicio codigo postal :: {}", respuesta);
			salida = respuesta.getBody();
		} catch (Exception e) {
			logger.error("Error CP :: {}", e);
		}
		return salida;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * consultarDocumentosRequeridosPorClaveAfore(java.lang.String)
	 */
	@Override
	public List<DocumentosRequerido> consultarDocumentosRequeridosPorClaveAfore(String claveAfore) {
		String url = MessageFormat.format(consultaDocumentosRequeridos, new Object[] { claveAfore });
		logger.info("url consulta historico retiros: {}", url);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Void> entidadEntrada = new HttpEntity<>(headers);
		ResponseEntity<BaseRespuesta<List<DocumentosRequerido>>> salida = servicioCliente.exchange(url, HttpMethod.GET,
				entidadEntrada, new ParameterizedTypeReference<BaseRespuesta<List<DocumentosRequerido>>>() {
				});

		if (salida == null || salida.getBody() == null) {
			return Arrays.asList();
		}

		return salida.getBody().getObjetoRespuesta();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nacionalidad obtenerNacionalidadPorClaveCorta(String claveCorta) {
		logger.info("Se obtiene datos de nacionalidad por clave cora: {}", claveCorta);
		Nacionalidad nacionalidad = null;
		try {
			String url = new StringBuilder(servicioCatalogo)
					.append(ModificacionTrabajadorConstants.SERVICIO_NACIONALIDAD_CLAVE_CORTA).append(claveCorta)
					.toString();
			logger.info("Url nacionalidad corta: {}", url);
			nacionalidad = servicioCliente.getForObject(url, Nacionalidad.class);
			logger.info("Respuesta nacionalidad: {}", nacionalidad);
		} catch (Exception e) {
			logger.error(ServiciosConstants.LOG_NACIONALIDADES, e);
		}
		return nacionalidad;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerCatalogoGenero()
	 */
	@Override
	public List<Genero> obtenerCatalogoGenero() {
		ResponseEntity<List<Genero>> salida = servicioCliente.exchange(
				RequestEntity.get(URI.create(consultaGeneros)).build(), new ParameterizedTypeReference<List<Genero>>() {
				});

		if (salida == null || !salida.hasBody()) {
			return Collections.emptyList();
		}

		return salida.getBody();
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * obtenerCatalogoEntidadFederativa()
	 */
	@Override
	public EntidadFederativaList obtenerCatalogoEntidadFederativa() {
		return servicioCliente.getForEntity(consultaEntidadFederativa, EntidadFederativaList.class).getBody();
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#
	 * buscarTipoProceso(java.util.List)
	 */
	@Override
	public List<TipoProcesoExpediente> buscarTipoProceso(List<String> idTipoProceso) {
		HttpEntity<List<String>> request = new HttpEntity<List<String>>(idTipoProceso);
		return servicioCliente.exchange(consultaTipoProceso, HttpMethod.POST, request,
				new ParameterizedTypeReference<List<TipoProcesoExpediente>>() {
				}, idTipoProceso).getBody();
	}
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService#obtenerActuarios()
	 */
	@Override
	public List<Actuario> obtenerActuarios() {
		ActuarioList listaActuarios = null;
		List<Actuario> lista = null;
	    StringBuilder url = new StringBuilder();
	    url.append(uriComunes).append(ExpresionesConstants.CATALOGO).append(ExpresionesConstants.ACTUARIO_TODOS ).toString();
	    logger.info("Url obtenerActuarios:{}",url);
	    try {
			listaActuarios = servicioCliente.getForObject(url.toString(),ActuarioList.class);
			
			if (!utileriaValidador.validarObjetoNulo(listaActuarios)) {
				lista = listaActuarios.getListaActuario();
				
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Actuarios Autorizados {}",e);
		}
	    
		return lista;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ModuloReporte> obtenerModuloReportes() {
		logger.info("Se los diferentes modulos para las pantallas SICI");
		List<ModuloReporte> modulos = null;
		try {
			String urlReporte = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, ExpresionesConstants.CATALOGO, ExpresionesConstants.MODULO_REPORTES);
			String respuestaReporte = servicioCliente.getForObject(urlReporte, String.class);
			if (!utileriaValidador.validarVacio(respuestaReporte)) {
				JsonUtilsImpl<ModuloReporte> utileriaJson = new JsonUtilsImpl<>();
				modulos = utileriaJson.parseJsonToObjectList(respuestaReporte, ModuloReporte.class);
			}
		} catch (Exception e) {
			logger.error("Se presento un problema en la consulta de modulo de reportes", e);
		}
		return modulos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarIPAccesoSICI(String ip, String afore) {
		logger.info("Se consulta si la ip esta activa para el acceso, {} {}", ip, afore);
		boolean ipValida = false;
		try {
			String urlacceso = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, ExpresionesConstants.CATALOGO, ExpresionesConstants.VALIDAR_ACCESO_VIP);
			urlacceso = String.format(urlacceso, ip, afore);
			AccesoVIP respuestaAcceso = servicioCliente.getForObject(urlacceso, AccesoVIP.class);
			if (!utileriaValidador.validarObjetoNulo(respuestaAcceso)) {
				ipValida = true;
			}
		} catch (Exception e) {
			logger.error("Se presento un problema en la consulta de modulo de reportes", e);
		}
		return ipValida;
	}
	
	/**
	 * Metodo para obtener parametros PSER_TC_PARAMETRO
	 * @param parametro
	 * @param claveParametro
	 * @return claveParentesco
	 */	
	@Override
	public String consultaValorParametro(String parametro, String claveParametro) {
		String datoParametro = "";
		try{
			logger.error("ConsultaValorParametro. parametro: {} , claveParametro {} ", parametro, claveParametro);
			StringBuilder sb= new StringBuilder();
			sb.append(uriComunes);
			sb.append(ServiciosConstants.SERVICIO_PARAMETRO);
			sb.append(parametro);
			sb.append("/");
			sb.append(ServiciosConstants.CLAVE);
			sb.append("/");
			sb.append(claveParametro);
			
			logger.error("ConsultaValorParametro. La url del servicio obtenerValorParametro a invocar es: {}", sb.toString());
			datoParametro = restServiceClientUtils.ejecutarServicioGet("", sb.toString(), String.class);
			logger.error("ConsultaValorParametro. Los Datos son: {}", datoParametro);
		}catch(Exception ex) {
			logger.error("ConsultaValorParametro. Exception:: {}", ex);
		}		
		return datoParametro;
	}
	
	/**
	 * Metodo encargado de obtener datos de entidad federativa por claveEntidad
	 */
	@Override
	public EntidadFederativa obtenerEntidadFederativaComunes(String claveEntidadFederativa) {
		EntidadFederativa salida = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(uriComunes);
			sb.append(ServiciosConstants.CATALOGO);
			sb.append(ModificacionTrabajadorConstants.SERVICIO_ENTIDAD_POR_CLAVE);
			sb.append(claveEntidadFederativa);
			logger.error("URL catalogo entidad federativa: {}", sb.toString());
			salida = servicioCliente.getForObject(sb.toString(), EntidadFederativa.class);
		} catch (Exception e) {
			salida = new EntidadFederativa();
			logger.error("Error obtenerEntidadFederativa por clave", e);
		}
		return salida;
	}
}