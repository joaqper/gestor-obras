package Interface;

public interface InterfazExportable<T>
{
    //Método para que todas las clases que importen exportable tengan que exportar.
    void exportarTxt(String ruta);
}