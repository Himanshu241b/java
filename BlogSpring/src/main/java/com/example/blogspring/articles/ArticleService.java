package com.example.blogspring.articles;

import com.example.blogspring.articles.dtos.CreateArticleRequest;
import com.example.blogspring.articles.dtos.UpdateArticleRequest;
import com.example.blogspring.users.UserService;
import com.example.blogspring.users.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private ArticlesRepository articlesRepository;
    private UsersRepository usersRepository;

    public ArticleService(ArticlesRepository articlesRepository, UsersRepository usersRepository) {
        this.articlesRepository = articlesRepository;
        this.usersRepository = usersRepository;
    }

    public Iterable<ArticleEntity> getAllArticles(){
        return articlesRepository.findAll();
    }

    public ArticleEntity getArticleBySlug(String slug){
        var article =  articlesRepository.findBySlug(slug);
        if(article == null)
            throw new ArticleNotFoundException("Article "+ slug+" not found.");
        return article;
    }

    public ArticleEntity createArticle(CreateArticleRequest createArticleRequest, Long authorId){
        var author = usersRepository.findById(authorId).orElseThrow(()->new UserService.UserNotFoundException(authorId));
        var newArticle = articlesRepository.save(ArticleEntity.builder()
                        .title(createArticleRequest.getTitle())
                        //Todo: create a sluggification method
                        .slug(createArticleRequest.getTitle().toLowerCase().replaceAll("\\s+","-"))
                        .subtitle(createArticleRequest.getSubtitle())
                        .body(createArticleRequest.getBody())
                        .author(author)
                        .build());
        return newArticle;
    }

    public ArticleEntity updateArticle(Long articleId, UpdateArticleRequest updateArticleRequest){
        var article = articlesRepository.findById(articleId).orElseThrow(()-> new ArticleNotFoundException(articleId));

        if(updateArticleRequest.getTitle() != null) {
            article.setTitle(updateArticleRequest.getTitle());
            article.setSlug(updateArticleRequest.getTitle().toLowerCase().replaceAll("\\s+","-"));
        }
        if(updateArticleRequest.getBody() != null)
            article.setBody(updateArticleRequest.getBody());
        if(updateArticleRequest.getSubtitle() != null)
            article.setSubtitle(updateArticleRequest.getSubtitle());\

        return articlesRepository.save(article);
    }

    public static class ArticleNotFoundException extends IllegalArgumentException{
        public ArticleNotFoundException(String slug){
            super("Article with slug " + slug + " not found");
        }
        public ArticleNotFoundException(Long id){
            super("Article with id " + id + " not found");
        }

    }
}
