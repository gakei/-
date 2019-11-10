package WHJ.service;


import WHJ.mapper.QuestionMapper;
import WHJ.mapper.UserMapper;
import WHJ.model.Question;
import WHJ.model.QuestionDTO;
import WHJ.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    List<QuestionDTO> questionDTOList = new ArrayList<>();
    public List<QuestionDTO> list() {
        List<Question> list = questionMapper.list();
        for (Question question : list) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
