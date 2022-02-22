<?PHP
    require_once "conexion.php";
    $conexion=conexion();
    
    $consulta="SELECT * FROM usuarios";
    $resultado=mysqli_query($conexion,$consulta);
    
    while($registro=mysqli_fetch_array($resultado)){
        $json['usuarios'][]=$registro;
    }
    
    mysqli_close($conexion);
    echo json_encode($json)
    
?>