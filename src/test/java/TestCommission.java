
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCommission {
    @Mock
    private Lock lock = Mockito.mock(Lock.class);
    @Mock
    private Stock stock = Mockito.mock(Stock.class);
    @Mock
    private Barrel barrel = Mockito.mock(Barrel.class);

    @InjectMocks
    CalculateCommission c = new CalculateCommission();

    @Before
    public void setUp(){ MockitoAnnotations.openMocks(this); }

    @Test
    public void testGetCommissionSkipWhileLoop() {

    }

    @Test
    public void testGetCommissionEnterWhileLoop() {
        Lock l = spy(new Lock(5)); // spy object rather than real object or mock (includes structure of full object)
        when(l.getCount()).thenReturn(5);
        when(stock.getCount()).thenReturn(5);
        when(barrel.getCount()).thenReturn(5);
        double com = c.getCommission(lock, stock, barrel);
        Assert.assertEquals(520.0, com, 0);
    }
}