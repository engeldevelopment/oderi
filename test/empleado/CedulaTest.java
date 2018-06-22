
package empleado;

import modelo.Cedula;
import excepciones.ContenidoInvalidoException;
import org.junit.*;
import static org.junit.Assert.*;

public class CedulaTest {
    
    public CedulaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaConMenosDeSeisDigitosDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("22222");
    }
    
    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaConMenosDeOchoDigitosDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("222222223");
    }
    
    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaVaciaDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("");
    }
    
    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaConLetrasDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("223872y6");
    }
    
    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaConUnCaracterEspecialDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("2*3872'6");
    }
    
    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaConUnEspaciosDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("2 38726");
    }
    
    @Test(expected = ContenidoInvalidoException.class)
    public void dadaUnaCedulaLlenaDeEspeciosDaError() throws ContenidoInvalidoException {
        
        Cedula cedula = new Cedula("        ");
    }
}
