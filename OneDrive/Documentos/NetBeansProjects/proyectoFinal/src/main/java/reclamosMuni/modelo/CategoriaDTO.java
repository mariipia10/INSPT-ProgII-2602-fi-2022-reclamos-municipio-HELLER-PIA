package reclamosMuni.modelo;

/*
 * 
 * 
 */



/**
 *
 * @author piahe
 */
public class CategoriaDTO {
    private int id;
    private String tipo;

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" + "id=" + id + ", tipo=" + tipo + '}';
    }


}
