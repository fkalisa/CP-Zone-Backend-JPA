package com.example.demo.JPAbackendZone.resource;

import com.example.demo.JPAbackendZone.dao.GitHubUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GitUserController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/gitHub/users/{login}")
    public GitHubUser getUser(@PathVariable String login) {
        ResponseEntity<GitHubUser> entity = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GitHubUser.class);
        return entity.getBody();
    }
}
