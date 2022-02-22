<?PHP
    require_once "conex.php";
    $conexion=conex();
    
$IdPlan = $_REQUEST["IdPlan"];
    $nombrePlan= $_REQUEST['nombrePlan'];
    $descripcionPlan= $_REQUEST['descripcionPlan'];
    $IdUsuario= $_REQUEST['IdUsuario'];
    //$IdUsuario= $_REQUEST['IdUsuario'];
    
    $registros=array();
    
    $sql="UPDATE Planes SET nombrePlan='$nombrePlan', descripcionPlan='$descripcionPlan', IdUsuario='$IdUsuario' WHERE IdPlan='$IdPlan'";
    try{
        $ejecutar = mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
    echo json_encode($registros);}
    catch(Exception $e){ 
        echo "error"; 
    }
    
?>