document.addEventListener("click", function (e) {
    var enlace = e.target.closest("a[data-confirmar]");
    if (!enlace) {
        return;
    }
    e.preventDefault();

    var modal = document.getElementById("modalConfirmar");
    document.getElementById("modalTexto").textContent = enlace.getAttribute("data-confirmar");
    modal.style.display = "flex";

    document.getElementById("modalAceptar").onclick = function () {
        window.location.href = enlace.href;
    };
    document.getElementById("modalCancelar").onclick = function () {
        modal.style.display = "none";
    };
});

