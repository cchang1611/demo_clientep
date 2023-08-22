<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<body>
	<link rel="stylesheet" type="text/css" href="../webResources/css/1.5.8/slick-theme.min.css">
	<link rel="stylesheet" type="text/css" href="../webResources/css/1.5.8/slick.css">
	<link rel="stylesheet" type="text/css" href="../webResources/css/general/carousel/slick_carousel.css">
	<section>
		<div class="slick-carousel">
			<m:choose>
				<m:when test="${sessionScope.subMenuUsuario != null}">
					<m:forEach items="${sessionScope.subMenuUsuario}" var="menu">	
						<m:choose>
							<m:when test="${fn:contains(menu.chRutaMenu, 'datosIdentificacion.do')}">
								<a href="${menu.chRutaMenu}" class="Carrousel__ThumbContainer">
									<m:choose>
										<m:when test="${expedienteB.banderaExpedienteIdentifiacion == 1}">
											<div class="Icon_Check">
												<img  class="IconImg" src="../webResources/img/icon_paloma.png" alt="icon_ok"/>
											</div>
										</m:when>
										<m:when test="${expedienteB.banderaExpedienteIdentifiacion == 2}">
											<div class="Icon_Check">
												<img  class="IconImg" src="../webResources/img/paloma_amarilla.png" alt="icon_pendiente"/>
											</div>
										</m:when>
										<m:otherwise>
											<div class="Icon_Check">
												<img  class="IconImg" src="../webResources/img/icon_tache.png" alt="icon_tache"/>
											</div>
										</m:otherwise>
									</m:choose>
									<div class="Icon">
										<img class="IconImgMenu" src="${menu.chImagen}" alt="icon_menu"/>
									</div>
									<div class="Carrousel__Title">${menu.chDescMenuPagina}</div>
								</a>
							</m:when>
							<m:when test="${fn:contains(menu.chRutaMenu, 'datosBiometricos.do')}">
								<a href="${menu.chRutaMenu}" class="Carrousel__ThumbContainer">
									<m:choose>
										<m:when test="${expedienteB.banderaEnrolamiento == 1}">
											<div class="Icon_Check">
												<img  class="IconImg" src="../webResources/img/icon_paloma.png" alt="icon_ok"/>
											</div>
										</m:when>
										<m:when test="${expedienteB.banderaEnrolamiento == 2}">
											<div class="Icon_Check">
												<img  class="IconImg" src="../webResources/img/paloma_amarilla.png" alt="icon_pendiente"/>
											</div>
										</m:when>
										<m:otherwise>
											<div class="Icon_Check">
												<img  class="IconImg" src="../webResources/img/icon_tache.png" alt="icon_tache"/>
											</div>
										</m:otherwise>
									</m:choose>
									<div class="Icon">
										<img class="IconImgMenu" src="${menu.chImagen}" alt="icon_menu"/>
									</div>
									<div class="Carrousel__Title">${menu.chDescMenuPagina}</div>
								</a>
							</m:when>
							<m:otherwise>
								<a href="${menu.chRutaMenu}" class="Carrousel__ThumbContainer">
									<div class="Icon">
										<img class="IconImgMenu" src="${menu.chImagen}" alt="icon_menu">
									</div>
									<div class="Carrousel__Title">${menu.chDescMenuPagina}</div>
								</a>
							</m:otherwise>
						</m:choose>	
					</m:forEach>
				</m:when>
			</m:choose>
		</div>
	</section>
	<script type="text/javascript" charset="UTF-8" src="../webResources/js/slick.min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="../webResources/js/slick_carousel.js" /></script>
</body>
</html>
