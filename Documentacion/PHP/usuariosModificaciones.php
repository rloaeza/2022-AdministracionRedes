<?PHP
    require_once "conexion.php";
    $conexion=conexion();
    
    $email - $_REQUEST["email"];
    $contrasena - $_REQUEST["contraseña"];
    $permisos - $_REQUEST["permisos"];
    
    $registros=array();
    
    $sql="UPDATE usuarios SET email='$email', contrasena='$contrasena', permisos='$permisos' WHERE email='$email' ";
    try{
        $ejecutar - mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="usuario modificado";
        
        echo json_encode($registros);
    }
    catch(Exception $e){ echo "error"; }
    
?>