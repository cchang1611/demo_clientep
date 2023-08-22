<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="Banner__Container">
      <div class="Banner__Thumbnail">
        <img src="${param.imagen_encabezado}">
        <div class="Banner__TextContainer">
          <h1 class="Banner__TitleContainer">
            ${param.titulo_encabezado}
          </h1>
        </div>
      </div>
    </div>
</body>
</html>