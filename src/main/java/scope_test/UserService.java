package scope_test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {
    private Long a;
    private String b;
    private Integer c;
}
