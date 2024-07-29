package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        return ResponseEntity.ok().
                header("X-Total-Count", String.valueOf(posts.size())).body(posts);
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> show(@PathVariable String id) {
        Optional<Post> result = posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (result.isPresent()) {
            return ResponseEntity.of(Optional.of(result));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return  ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post post) {
        var result = posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (result.isPresent()) {
            var newPost = result.get();
            newPost.setId(post.getId());
            newPost.setTitle(post.getTitle());
            newPost.setBody(post.getBody());
            return ResponseEntity.ok().body(post);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(post);
        }

    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
