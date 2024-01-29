//package avangardteen.java2app.service;
//
//import avangardteen.java2app.CoreError;
//import avangardteen.java2app.UserSizes;
//import avangardteen.java2app.request.AddAnthropometricDataRequest;
//import avangardteen.java2app.responce.AddAnthropometricDataResponse;
//import avangardteen.java2app.service.valigation.AddAntropologDateValigation;
//import classWork.core.requests.AddBookRequest;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AddAtropologDateServisTest {
//  @Mock UserSizes sizes;
//  @Mock AddAntropologDateValigation valigation;
//  @InjectMocks AddAtropologDateServis servis;
//  @Test
//  public  void test1() {
//   AddAnthropometricDataRequest request = new AddAnthropometricDataRequest(12,13,14,15);
//   when(valigation.errorlist(request)).thenReturn(List.of(new CoreError("x", "y")));
//   AddAnthropometricDataResponse response = servis.execute(request);
//   assertTrue(response.hasErrors());
//   assertEquals(response.getErrorList().get(0).getLocation(),"x");
//   assertEquals(response.getErrorList().get(0).getMessage(),"y");
//   verifyNoInteractions(sizes);
//  }
//  @Test
//    public  void test2() {
//        AddAnthropometricDataRequest request = new AddAnthropometricDataRequest(12,13,14,15);
//        when(valigation.errorlist(request)).thenReturn(new ArrayList<>());
//        AddAnthropometricDataResponse response = servis.execute(request);
//        assertFalse(response.hasErrors());
//        verify(sizes).setPelvisWidth(12);
//        verify(sizes).setThighLength(13);
//        verify(sizes).setBackHeight(14);
//        verify(sizes).setShinLength(15);
//    }
//
//}