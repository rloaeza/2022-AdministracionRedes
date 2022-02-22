<?PHP

    require_once "conex.php";
        $conexion=conex();
        
        $json=array();
        
        if(isset($_GET["IdPlan"])){
            $IdPlan=$_GET["IdPlan"];
            
            $sql="DELETE FROM Almacen WHERE IdAlmacen='{$IdPlan}'";
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