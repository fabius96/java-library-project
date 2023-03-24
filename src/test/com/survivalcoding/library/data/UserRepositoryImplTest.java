package test.com.survivalcoding.library.data;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.survivalcoding.library.data.Data;
import com.survivalcoding.library.data.UserRepositoryImpl;
import com.survivalcoding.library.domain.model.User;

public class UserRepositoryImplTest {
    UserRepositoryImpl repository;

    User user1 = new User("홍길동", 0, 10, "address", "010-1212-1231", new Date(), new Date());
    User user2 = new User("박경덕");
    User user3 = new User("이동학");
    User user4 = new User("박준하");

    @Before
    public void setUp() throws Exception {
        repository = new UserRepositoryImpl(new Data<User>() {
            
            @Override
            public void save(List<User> items) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public List<User> load() {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public void backup() {
                // TODO Auto-generated method stub
                
            }
        });
    }

    @Test
    public void 유저가_잘_추가된다() {
        repository.addUser(user1);
        assertEquals(1, repository.findAll().size());
        
        repository.addUser(new User("박경덕"));
        assertEquals(2, repository.findAll().size());
    }
    
//    @Test(expected = IllegalArgumentException.class)
//    public void id가_중복인_유저는_추가_불가() {
//        repository.addUser(new User("박경덕"));
//        assertEquals(1, repository.findAll().size());
//        
//        repository.addUser(new User("이동학"));
//        assertEquals(1, repository.findAll().size());
//    }
    
    @Test
    public void 삭제가_잘_되어야_한다() {
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        
        repository.deleteUser(user1);
        assertEquals(2, repository.findAll().size());
        
        repository.deleteUser(user2);
        assertEquals(1, repository.findAll().size());
        
        repository.deleteUser(user2);
        assertEquals(1, repository.findAll().size());
    }
    
    @Test
    public void 업데이트_테스트() {
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        
        User user5 = new User("박준하");
        user5.setName("김재영");
        
        repository.updateUser(user5);
        
        User user = repository.findById(3);
        
        assertEquals("김재영", user.getName());
    }
    
    @Test
    public void id나_이름으로_찾기() {
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        
        assertEquals("이동학", repository.findById(2).getName());
        assertEquals(2, repository.findByName("이동학").getId());
    }

}










