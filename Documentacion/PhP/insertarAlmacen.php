<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $cantidad= $_REQUEST['cantidad'];
    $categoria= $_REQUEST['categoria'];
    
    $registros=array();
    
    $sql="INSERT INTO Almacen (nombre,descripcion,cantidad,categoria) VALUES('$nombre','$descripcion','$cantidad','$categoria')";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>