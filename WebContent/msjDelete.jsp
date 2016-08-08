<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
    <h4 class="blue bigger">Eliminar Tipo Hospedaje</h4>
</div>
<div class="modal-body">
    <form class="form-horizontal" id="formDeleteTipo" action="" method="POST">
        <input type="hidden" name="idTipo" value="">
        Seguro que desea eliminar el Tipo de Hospedaje <strong> nombre </strong>?
    </form>
</div>
<div class="modal-footer">
    <button id="aceptarDeleteTipo" class="btn btn-small btn-primary">
        <i class="icon-ok"></i>
        Aceptar
    </button>
    <button class="btn btn-small" data-dismiss="modal">
        <i class="icon-remove"></i>
        Cancelar
    </button>
</div>
<script type="text/javascript">
        $('#aceptarDeleteTipo').on('click', function (event) {
            event.preventDefault();
            $('#formDeleteTipo').submit();
        });
</script>