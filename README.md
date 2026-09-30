# SolarTechWeb

Proyecto Java Web (Maven, WAR, Jakarta EE 10) del sistema **SolarTech**.

## Estructura
- `src/main/webapp` (Web Pages): `images/`, `lib/` (header.jsp, footer.jsp), `scripts/`, `styles/style.css`,
  `index.jsp`, `login.jsp`, `adminUsuarios.jsp`, `registroUsuarios.jsp`, `adminProductos.jsp`, `registroProductos.jsp`
- `src/main/java/Modelo`: `Persona`, `Usuario`, `Producto`, `GestionarUsuarios`, `GestionarProductos`
- `src/main/java/Servlets`: reservado para la siguiente entrega

## Ejecutar
Abrir en NetBeans y ejecutar con Apache Tomcat 10.1+ (o GlassFish 7 / Payara 6).
URL: `http://localhost:8080/SolarTechWeb/`

Nota: esta entrega contiene solo vistas con navegación y formularios (sin funcionalidad).
