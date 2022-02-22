<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $nombrePlan = $_REQUEST["nombrePlan"];
    $descripcionPlan = $_REQUEST["descripcionPlan"];
    $IdUsuario = $_REQUEST["IdUsuario"];
    
    $usuario = array();
    
    $sql = "INSERT INTO Planes (nombrePlan, descripcionPlan, IdUsuario) VALUES ( '$nombrePlan', '$descripcionPlan', '$IdUsuario')";
    
    $resultado_insert = mysqli_query($conexion, $sql);
    
    if($resultado_insert){
       $usuario["creado"] ="1";
       $usuario["usuario"]="usuario dado de alta";
       $json["resultado"][]=$usuario;
       echo json_encode($json);
    }
    else{
        echo "error al registrar el usuario";
    }
   
    
?>