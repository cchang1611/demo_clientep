
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NotificarAutenticacionResponse_QNAME = new QName("http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", "notificarAutenticacionResponse");
    private final static QName _NotificarAutenticacionRequest_QNAME = new QName("http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", "notificarAutenticacionRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotificarAutenticacionRespuesta }
     * 
     */
    public NotificarAutenticacionRespuesta createNotificarAutenticacionRespuesta() {
        return new NotificarAutenticacionRespuesta();
    }

    /**
     * Create an instance of {@link NotificarAutenticacionContrato }
     * 
     */
    public NotificarAutenticacionContrato createNotificarAutenticacionContrato() {
        return new NotificarAutenticacionContrato();
    }

    /**
     * Create an instance of {@link NotificarAutenticacionSalida }
     * 
     */
    public NotificarAutenticacionSalida createNotificarAutenticacionSalida() {
        return new NotificarAutenticacionSalida();
    }

    /**
     * Create an instance of {@link NotificarAutenticacionEntrada }
     * 
     */
    public NotificarAutenticacionEntrada createNotificarAutenticacionEntrada() {
        return new NotificarAutenticacionEntrada();
    }

    /**
     * Create an instance of {@link IDSSN }
     * 
     */
    public IDSSN createIDSSN() {
        return new IDSSN();
    }

    /**
     * Create an instance of {@link Motivo }
     * 
     */
    public Motivo createMotivo() {
        return new Motivo();
    }

    /**
     * Create an instance of {@link SSNROP }
     * 
     */
    public SSNROP createSSNROP() {
        return new SSNROP();
    }

    /**
     * Create an instance of {@link MotivoRest }
     * 
     */
    public MotivoRest createMotivoRest() {
        return new MotivoRest();
    }

    /**
     * Create an instance of {@link ArrayOfMotivosRest }
     * 
     */
    public ArrayOfMotivosRest createArrayOfMotivosRest() {
        return new ArrayOfMotivosRest();
    }

    /**
     * Create an instance of {@link IDSSNS }
     * 
     */
    public IDSSNS createIDSSNS() {
        return new IDSSNS();
    }

    /**
     * Create an instance of {@link ArrayOfMotivos }
     * 
     */
    public ArrayOfMotivos createArrayOfMotivos() {
        return new ArrayOfMotivos();
    }

    /**
     * Create an instance of {@link SSNROPREST }
     * 
     */
    public SSNROPREST createSSNROPREST() {
        return new SSNROPREST();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificarAutenticacionRespuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", name = "notificarAutenticacionResponse")
    public JAXBElement<NotificarAutenticacionRespuesta> createNotificarAutenticacionResponse(NotificarAutenticacionRespuesta value) {
        return new JAXBElement<NotificarAutenticacionRespuesta>(_NotificarAutenticacionResponse_QNAME, NotificarAutenticacionRespuesta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificarAutenticacionContrato }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.procesar.com.mx/ServiciosInternos/PortalServicios/AutenticacionINE/notificarAutenticacion/", name = "notificarAutenticacionRequest")
    public JAXBElement<NotificarAutenticacionContrato> createNotificarAutenticacionRequest(NotificarAutenticacionContrato value) {
        return new JAXBElement<NotificarAutenticacionContrato>(_NotificarAutenticacionRequest_QNAME, NotificarAutenticacionContrato.class, null, value);
    }

}
