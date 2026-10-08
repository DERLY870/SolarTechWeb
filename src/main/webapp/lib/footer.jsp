<%@page contentType="text/html" pageEncoding="UTF-8"%>
        </main>

        <div id="modalConfirmar" class="modal-fondo">
            <div class="modal-caja">
                <h3>SolarTech</h3>
                <p id="modalTexto"></p>
                <button id="modalAceptar" class="boton">Aceptar</button>
                <button id="modalCancelar" class="boton secundario">Cancelar</button>
            </div>
        </div>

        <footer>
            <p>&copy; 2026 SolarTech - Gesti&oacute;n de instalaciones fotovoltaicas</p>
            <p>Proyecto acad&eacute;mico Java Web</p>
        </footer>
        <script src="<%= request.getContextPath() %>/scripts/confirmar.js"></script>
    </body>
</html>