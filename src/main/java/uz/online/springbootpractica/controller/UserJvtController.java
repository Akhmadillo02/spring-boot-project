package uz.online.springbootpractica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.online.springbootpractica.LoginVm;
import uz.online.springbootpractica.domein.User;
import uz.online.springbootpractica.repository.UserRepository;
import uz.online.springbootpractica.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserJvtController {

    private final AuthenticationManager authonticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    public UserJvtController(AuthenticationManager authonticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authonticationManager = authonticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginVm loginVm) {
        authonticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVm.getUserName(), loginVm.getPassword()));
        User user = userRepository.findByLogin(loginVm.getUserName());
        if (user == null) {
            throw new UsernameNotFoundException("bu user mavjud emaas");
        }
        String token = jwtTokenProvider.createToken(user.getUserName(), user.getRoles());
        Map<Object,Object> map = new HashMap<>();
        map.put("userName",user.getUserName());
        map.put("token", token);
        System.out.println("dfjhfdjhf"+token);
        return ResponseEntity.ok(map);
    }

}
