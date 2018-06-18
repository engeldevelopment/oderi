package empleado;

import seguridad.*;
import excepciones.*;
import nullObjects.NullUsuario;
import dao.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class LoginTest {
    
    private ServicioDeLogin servicio;
    private IServicioDeUsuario servicioDeUsuario;
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servicioDeUsuario = mock(UsuarioDAO.class);
        servicio = new ServicioDeLogin(servicioDeUsuario);
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = CamposVaciosException.class)
    public void composVacios() throws CamposVaciosException, 
            UsuarioIncorrectoException,
            ClaveIncorrectaException {
        
        servicio.login("","");
    }
    
    @Test(expected = CamposVaciosException.class)
    public void FaltaUnComposPorIngresar() throws CamposVaciosException, 
            UsuarioIncorrectoException,
            ClaveIncorrectaException {
        
        servicio.login("Engel","");
    }
    
    @Test(expected = UsuarioIncorrectoException.class)
    public void usuarioIncorrecto() throws UsuarioIncorrectoException, 
            CamposVaciosException,
            ClaveIncorrectaException {
        
        when(servicioDeUsuario.buscar("Engel")).thenReturn(new NullUsuario());
        servicio.login("Engel","1234");
    }
    
    @Test(expected = ClaveIncorrectaException.class)
    public void claveDelUsuarioIncorrecta() throws UsuarioIncorrectoException, 
            CamposVaciosException, ClaveIncorrectaException {
        
        when(servicioDeUsuario.buscar("Engel")).thenReturn(new Usuario("Engel","123"));
        servicio.login("Engel","1234");
    }
    
    @Test
    public void loginExitoso() throws UsuarioIncorrectoException, 
            CamposVaciosException, ClaveIncorrectaException {
        
        when(servicioDeUsuario.buscar("Engel")).thenReturn(new Usuario("Engel","1234"));
        Usuario usuario = servicio.login("Engel","1234");
        
        assertFalse(usuario.esNull());
    }
    
    @Test(expected = CamposVaciosException.class)
    public void noSeAceptanEspaciosVacios() throws CamposVaciosException, 
            UsuarioIncorrectoException,
            ClaveIncorrectaException {
        
        servicio.login(" ", " ");
    }
}
