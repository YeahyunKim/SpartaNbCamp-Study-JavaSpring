package com.sparta.springmemo.service;

import com.sparta.springmemo.dto.MemoRequestDto;
import com.sparta.springmemo.dto.MemoResponseDto;
import com.sparta.springmemo.entity.Memo;
import com.sparta.springmemo.repository.MemoRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MemoService {
    private final JdbcTemplate jdbcTemplate;

    public MemoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);

        // DB 저장
        MemoRepository memoRepository = new MemoRepository(jdbcTemplate);
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        MemoRepository memoRepository = new MemoRepository(jdbcTemplate);
        return memoRepository.findAll();
    }

    public Long updateMemo(long id, MemoRequestDto requestDto) {
        MemoRepository memoRepository = new MemoRepository(jdbcTemplate);
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id);
        if (memo != null) {
            memoRepository.update(id, requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    public Long deleteMemo(Long id) {
        MemoRepository memoRepository = new MemoRepository(jdbcTemplate);

        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id);
        if (memo != null) {
            memoRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}
