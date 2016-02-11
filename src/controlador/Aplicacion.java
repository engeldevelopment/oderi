
package controlador;

import vista.Menu;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Aplicacion {
    
    private static Aplicacion aplicacion;
    private ArrayList<IControlador> controladores;
    private MenuController menu;
    private EmpleadosController empleados;
    private AsistenciaController asistencias;
    private SubMenuController subMenu;
    private JornadaController jornadas;
    private InasistenciasController inasistencias;
    private PermisosController permisos;
    private Menu vistaPrincipal;
    
    private Aplicacion() {
        
    }
    
    public static Aplicacion get() {
        if (aplicacion == null) {
            aplicacion = new Aplicacion();
        }
        return aplicacion;
    }
    
    public void iniciar() {
        lookAndFeel();
        instancias();
        controladores();
        vistaMenu();
    }
    
    private void lookAndFeel() {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    private void instancias() {
        controladores = new ArrayList<>();
        vistaPrincipal = new Menu();
        menu = new MenuController(vistaPrincipal);
        empleados = new EmpleadosController(vistaPrincipal);
        asistencias = new AsistenciaController(vistaPrincipal);
        subMenu = new SubMenuController(vistaPrincipal);
        jornadas = new JornadaController(vistaPrincipal);
        inasistencias = new InasistenciasController(vistaPrincipal);
        permisos = new PermisosController(vistaPrincipal);
        
        controladores.add(menu);
        controladores.add(subMenu);
        controladores.add(empleados);
        controladores.add(asistencias);
        controladores.add(jornadas);
        controladores.add(inasistencias);
        controladores.add(permisos);
    }
    
    private void controladores() {
        for (IControlador controlador: controladores) {
            controlador.iniciar();
        }
    }
    
    private void vistaMenu() {
        vistaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vistaPrincipal.setVisible(true);
    }
}