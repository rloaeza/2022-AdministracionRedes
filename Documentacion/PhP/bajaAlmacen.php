<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["IdAlmacen"])){
            $IdAlmacen=$_GET["IdAlmacen"];
            
            $sql="DELETE FROM Almacen WHERE IdPrueba='{$IdAlmacen}'";
            $stm=$conexion->prepare($sql);
            
            if($stm->execute()){
                echo "elimina";
            }else{
                echo "noElimina";
            }
            
            mysqli_close($conexion);
        }
        else{
            echo "noExiste";
        }
?>