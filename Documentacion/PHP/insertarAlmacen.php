<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $cantidad= $_REQUEST['cantidad'];
    $categoria= $_REQUEST['categoria'];
    $IdUsuario= $_REQUEST['IdUsuario'];
    
    $registros=array();
    
    $sql="INSERT INTO Almacen (nombre,descripcion,cantidad,categoria,IdUsuario) VALUES('$nombre','$descripcion','$cantidad','$categoria','$IdUsuario')";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>