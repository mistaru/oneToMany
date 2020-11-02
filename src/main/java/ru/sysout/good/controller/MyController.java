package ru.sysout.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sysout.bad.dao.CommentRepository;
import ru.sysout.bad.dao.TopicRepository;
import ru.sysout.bad.model.Comment;
import ru.sysout.bad.model.Topic;
import ru.sysout.good.dao.GoodCommentRepository;
import ru.sysout.good.dao.GoodTopicRepository;
import ru.sysout.good.model.GoodComment;
import ru.sysout.good.model.GoodTopic;

import java.util.List;

@RestController
public class MyController {

    private final GoodCommentRepository goodCommentRepository;
    private final GoodTopicRepository goodTopicRepository;
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    public MyController(GoodCommentRepository goodCommentRepository, GoodTopicRepository goodTopicRepository, CommentRepository commentRepository, TopicRepository topicRepository) {
        this.goodCommentRepository = goodCommentRepository;
        this.goodTopicRepository = goodTopicRepository;
        this.commentRepository = commentRepository;
        this.topicRepository = topicRepository;
    }

    @GetMapping("/list1")
    List<GoodComment>  goodComments() {
        return goodCommentRepository.findAll();
    }

    @GetMapping("/good-comment/{id}")
    public GoodComment  goodComment(@PathVariable Long id) {
        return goodCommentRepository.findById(id).get();
    }

    @GetMapping("/good-topic/{id}")
    public GoodTopic goodTopic(@PathVariable Long id) {
        return goodTopicRepository.findById(id).get();
    }

    @GetMapping("/list2")
    List<GoodTopic>  goodTopics() {
        return goodTopicRepository.findAll();
    }

    @GetMapping("/list3")
    List<Comment>  comments() {
        return commentRepository.findAll();
    }

    @GetMapping("/list4")
    List<Topic>  topics() {
        return topicRepository.findAll();
    }

    @GetMapping("/comment/{id}")
    public Comment  comment(@PathVariable Long id) {
        return commentRepository.findById(id).get();
    }

    @GetMapping("/topic/{id}")
    public Topic topic(@PathVariable Long id) {
        return topicRepository.findById(id).get();
    }

}
