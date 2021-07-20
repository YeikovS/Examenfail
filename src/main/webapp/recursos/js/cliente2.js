$(document).ready(function (){
listarCliente2();
});
function listarCliente2(){
    $.get("fc",{"opc":1},function (data) {
        var x = JSON.parse(data);
        for(var i = 0;i<x.length;i++){
            $("#cliente").append("<option value='"+x[i].idcliente+"'>"+x[i].nombres+","+x[i].apellidos+"</option>");
        }
    });
}

