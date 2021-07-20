$(document).ready(function (){
listarVenta();
});
function listarVenta(){
    $.get("fc",{"opc":1},function (data) {
        var x = JSON.parse(data);
        for(var i = 0;i<x.length;i++){
            $("#venta").append("<option value='"+x[i].idventa+"'>"+x[i].tipodoc+"</option>");
        }
    });
}


