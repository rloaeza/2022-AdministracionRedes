<?PHP
    require_once "conex.php";
    $conexion = conex();
    
    $resultado = array();
    
    if(isset($_GET["IdUsuario"])){
        $IdUsuario = ($_GET["IdUsuario"]);
        
        $sql = "SELECT IdAlmacen, nombre, descripcion, cantidad, categoria, IdUsuario FROM Almacen WHERE IdUsuario ='$IdUsuario'";
        $llamada = mysqli_query($conexion, $sql);
        
        while($usuario = mysqli_fetch_array($llamada)){
            $resultado["usuario"][]= $usuario;
        }
        echo json_encode($resultado);
        //else{
            //echo "error durante la busqueda";
        //}
        
    }
    else{
        echo "el libro no se ha encontrado";
    }
    
    ?>
    