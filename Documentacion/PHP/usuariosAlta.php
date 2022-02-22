<?PHP
    require_once "conex.php";
    $conexion=conex();
    
    $email=$_REQUEST["email"];
    $contrasena=$_REQUEST["contrasena"];
    
    $registros=array();
    
    $sql="INSERT INTO usuarios (email,contrasena) VALUES('$email','$contrasena')";
    try{
        $ejecutar - mysqli_query($conexion,$sql);
        $registros["resultados"]=true;
        $registros["mensaje"]="servicio creado";
        
        echo json_encode($registros);
    }
    catch(Exception $e){ echo "error"; }
    
?>