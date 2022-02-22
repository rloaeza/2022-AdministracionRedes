<?PHP
    require_once "conexion.php";
    $conexion=conexion();
    
    $json=array();
    
    if(isset($_GET["email"])){
        $email=$_GET["email"];
        
        
        $consulta="SELECT email,contrasena,permisos FROM usuarios WHERE email='{$email}'";
        $resultado=mysqli_query($conexion,$consulta);
        
        if($registros=mysql_fetch_array($resultado)){ $json['usuarios'][]=$registro; }
        else{ 
            $resultar["email"]='no registra'; 
            $resultar["contrasena"]='no registra';
            $resultar["permisos"]='no registra';
            $json['usuarios'][]=$resultar;
        }
        
        mysqli_close($conexion);
        echo json_encode($json);
    }
    
    else{ 
        $resultar["success"]=0;
        $resultar["message"]='Ws no Retorna';
        $json['usuarios'][]=$resultar;
        echo json_encode($json);
    }
    
?>