<?PHP
    require_once "conexion.php";
    $conexion=conexion();
    
    $json=array();
    
    if(isset($_GET["email"])){
        $email=$_GET["email"];
        
        $sql="DELETE FROM usuarios WHERE email='{$email}'";
        $stm=$conexion->prepare($sql);
        
        if($stm->execute()){ echo "elimina"; }
        else{ echo "noElimina"; }
        
        mysqli_close($conexion);
    }
    
    else{ echo "noExiste"; }
    
?>