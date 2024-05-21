package com.sparta.springmemo.service;

import com.sparta.springmemo.dto.MemoRequestDto;
import com.sparta.springmemo.dto.MemoResponseDto;
import com.sparta.springmemo.entity.Memo;
import com.sparta.springmemo.repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);

        // DB 저장
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public MemoResponseDto updateMemo(long id, MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        memo.update(requestDto);
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        memoRepository.delete(memo);
        return id;
    }

    private Memo findMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}
