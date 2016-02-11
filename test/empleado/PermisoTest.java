
package empleado;

import excepciones.*;
import modelo.*;
import org.joda.time.DateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class PermisoTest {
    
    private Permiso permiso;
    private AnalizadorDePermiso analizador;
    private int dias;
    private DateTime fechaDeEmision;
    private DateTime fechaDeInicio;
    private DateTime fechaDeAnalisis;
    
    public PermisoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fechaDeEmision = new DateTime("2018-03-12");
        fechaDeInicio = new DateTime("2018-03-12");
    }
    
    @After
    public void tearDown() {
    
    }
    
    @Test
    public void permisoDe_1_dia() throws NumeroDeDiaIncorrectoException,
            FechaDeInicioIncorrecta,
            FechaDeInicioVacia {
        
        dias = 1;
        
        permiso = new Permiso(fechaDeEmision, fechaDeInicio, dias);
        permiso.emitir();
        
        assertEquals(new DateTime("2018-03-13"), permiso.getFechaDeCorte());
        
    }
    
    @Test
    public void permisoDe_2_dias() throws NumeroDeDiaIncorrectoException, 
            FechaDeInicioIncorrecta,
            FechaDeInicioVacia {
        
        dias = 2;
        
        permiso = new Permiso(fechaDeEmision, fechaDeInicio, dias);
        permiso.emitir();
        
        assertEquals(new DateTime("2018-03-14"), permiso.getFechaDeCorte());
    
    }
    
    @Test(expected = NumeroDeDiaIncorrectoException.class)
    public void permisoDe_0_dias() throws NumeroDeDiaIncorrectoException, 
            FechaDeInicioIncorrecta,
            FechaDeInicioVacia {
        
        dias = 0;
        
        permiso = new Permiso(fechaDeEmision, fechaDeInicio, dias);
        permiso.emitir();
        
    }
    
    @Test(expected = FechaDeInicioIncorrecta.class)
    public void fechaDeInicioMenorQueLaFechaDeEmision() throws 
            FechaDeInicioIncorrecta, NumeroDeDiaIncorrectoException, FechaDeInicioVacia {
        
        dias = 1;
        fechaDeInicio = new DateTime("2018-03-11");
        
        permiso = new Permiso(fechaDeEmision, fechaDeInicio, dias);
        permiso.emitir();
    }
    
    @Test(expected = FechaDeInicioVacia.class)
    public void fechaDeInicioVacia() throws 
            FechaDeInicioVacia, NumeroDeDiaIncorrectoException, 
            FechaDeInicioIncorrecta {
        
        dias = 1;
        
        permiso = new Permiso(fechaDeEmision, null, dias);
        permiso.emitir();
    }
}
