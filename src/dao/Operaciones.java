package dao;

import java.util.List;

/**
 * Nombre de la clase: Credenciales
 * version: 1.0
 * fecha: 4/06/2021
 * Copyright: ITCA-FEPADE
 * @author Ivan Alexander Osorio Tobar 020320
 * @author Jose Roberto Aragón Lopez 022120
 * @author Jonathan Cunza 
 */
public interface Operaciones {
    
    public boolean Insertar(Object obj);
    public boolean Eliminar(Object obj);
    public boolean Modificar(Object obj);
    public List<?> Seleccionar();
    
    
    
}
