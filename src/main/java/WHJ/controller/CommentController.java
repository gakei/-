package WHJ.controller;

import WHJ.dto.CommentCreateDTO;
import WHJ.dto.CommentDTO;
import WHJ.dto.ResultDTO;
import WHJ.enums.CommentTypeEnum;
import WHJ.exception.CustomizeErrorCode;
import WHJ.mapper.CommentMapper;
import WHJ.model.Comment;
import WHJ.model.User;
import WHJ.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody Map<String, Object> commentDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentDTO == null || StringUtils.isBlank((CharSequence) commentDTO.get("content"))) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(Long.parseLong((String)commentDTO.get("parentId")));
        comment.setContent((String) commentDTO.get("content"));
        comment.setType((Integer) commentDTO.get("type"));
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        comment.setCommentCount(0);
        commentService.insert(comment, user);
        return ResultDTO.okof();
    }

    @ResponseBody
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTarget(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okof(commentDTOS);
    }
}
