<?php
include 'conexion.php';
$email=$_POST['email'];
$contrasena=$_POST['contrasena'];

//$email="ferchokastedw@softortilla.com";
//$contrasena="12345678";

$sentencia=$conexion->prepare("SELECT * FROM usuarios WHERE email=? AND contrasena=?");
$sentencia->bind_param('ss',$email,$contrasena);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();
?>