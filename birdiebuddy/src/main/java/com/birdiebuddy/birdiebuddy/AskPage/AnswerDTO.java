//package com.birdiebuddy.birdiebuddy.AskPage;
//
//import lombok.Builder;
//
//public class AnswerDTO {
//    private String commentId;
//    private String postId;
//    private Long user;
//    private String content;
//    private String date;
//
//    @Builder
//    public AnswerDTO(AnswerToAsk answer)
//    {
//        this.commentId = answer.getCommentId();
//        this.postId = answer.getPostId();
//        this.user = answer.getUser();
//        this.content = answer.getContent();
//        this.date = answer.getDate();
//    }
//
//    public AnswerToAsk ToEntity()
//    {
//        return AnswerToAsk.builder()
//                .commentId(commentId)
//                .postId(postId)
//                .user(user)
//                .content(content)
//                .date(date)
//                .build();
//    }
//}
