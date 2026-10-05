package Interface;


public interface InterfazGestionable<T>
{
    //Método para agregar elementos
    void agregar(T elemento);
    //Método para eliminar elementos por id
    void eliminar(String id);
    //Método para buscar elementos por id
    T buscar(String id);
    //Método para que todas las clases gestionables se puedan listar
    void listar();
}