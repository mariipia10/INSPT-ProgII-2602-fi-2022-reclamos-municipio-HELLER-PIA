/*
 * 
 * 
 */

package reclamosMuni.modelo.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author piahe
 */
public class LoginDTO {

    
    int id;
    LocalDate dia;
    LocalTime hora;

    public LoginDTO(int id, LocalDate dia, LocalTime hora) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    
    
    
    
    

}
