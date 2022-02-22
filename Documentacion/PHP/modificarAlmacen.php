<?PHP
    require_once "conex.php";
    $conexion=conex();
    
$IdAlmacen = $_REQUEST["IdAlmacen"];
    $nombre= $_REQUEST['nombre'];
    $descripcion= $_REQUEST['descripcion'];
    $cantidad= $_REQUEST['cantidad'];
    $categoria= $_REQUEST['categoria'];
    //$IdUsuario= $_REQUEST['IdUsuario'];
    
    $registros=array();
    
    $sql="UPDATE Almacen SET nombre='$nombre', descripcion='$descripcion', cantidad='$cantidad', categoria='$categoria' WHERE IdAlmacen='$IdAlmacen'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>