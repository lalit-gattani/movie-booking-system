package com.interview.ticket.booking.system.service;

import com.interview.ticket.booking.system.dto.ShowDto;
import com.interview.ticket.booking.system.entity.Screen;
import com.interview.ticket.booking.system.entity.Show;
import com.interview.ticket.booking.system.entity.Theater;
import com.interview.ticket.booking.system.exception.CustomException;
import com.interview.ticket.booking.system.repository.ScreenRepository;
import com.interview.ticket.booking.system.repository.ShowRepository;
import com.interview.ticket.booking.system.repository.TheaterRepository;
import com.interview.ticket.booking.system.util.DtoUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ScreenRepository screenRepository;
    public List<ShowDto> getAllShowsForMovie(String movieId) {
        List<Show> showList = showRepository.getAllShows().values().stream().filter(e -> e.getMovieId().equals(movieId) && e.getIsActive()).collect(Collectors.toList());
        List<Theater> theaterList = showList.stream().map(e -> theaterRepository.getAllTheaters().get(e.getTheaterId())).collect(Collectors.toList());
        List<Screen> screenList = showList.stream().map(e -> screenRepository.getAllScreens().get(e.getScreenId())).collect(Collectors.toList());
        log.info("{} {} {}", showList, theaterList, screenList);
        return DtoUtil.toShowDto(showList, theaterList, screenList);
    }

    public void reserveSeats(String showId, List<Integer> seatNumbers) {
        Show show = showRepository.getAllShows().getOrDefault(showId, null);
        show.setAvailableSeats(show.getAvailableSeats() - seatNumbers.size());
        show.getAvailableSeatNumbers().removeAll(seatNumbers);
        showRepository.addShow(show);
    }

    public void unReserveSeats(String showId, List<Integer> seatNumbers) {
        Show show = showRepository.getAllShows().getOrDefault(showId, null);
        show.setAvailableSeats(show.getAvailableSeats() + seatNumbers.size());
        show.getAvailableSeatNumbers().addAll(seatNumbers);
        showRepository.addShow(show);
    }

    public ShowDto addShow(ShowDto showDto) throws CustomException {
        Screen screen = screenRepository.getAllScreens().getOrDefault(showDto.getScreenId(), null);
        Theater theater = theaterRepository.getAllTheaters().getOrDefault(showDto.getTheaterId(), null);
        if(Objects.isNull(screen))
            throw new CustomException("Screen Not Found");
        if(Objects.isNull(theater))
            throw new CustomException("Theater Not Found");

        Show show = DtoUtil.toShow(showDto, screen);
        showRepository.addShow(show);
        return DtoUtil.toShowDto(show, theater, screen);
    }
}
