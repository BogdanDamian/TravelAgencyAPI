package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.travel.dto.HotelDto;
import org.travel.dto.HotelRoomPriceDto;
import org.travel.dto.RoomDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.hotelRoomPriceException.HotelRoomPriceMeaninglessSearchException;
import org.travel.exception.hotelRoomPriceException.HotelRoomPricesNotFoundException;
import org.travel.mapper.HotelMapper;
import org.travel.mapper.HotelRoomPriceMapper;
import org.travel.mapper.RoomMapper;
import org.travel.model.HotelRoomPrice;
import org.travel.repository.HotelRoomPriceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelRoomPriceService {
    @Autowired
    private HotelRoomPriceRepository hotelRoomPriceRep;
    @Autowired
    private HotelRoomPriceMapper hotelRoomPriceMap;

    @Autowired
    private HotelService hotelSrv;
    @Autowired
    private HotelMapper hotelMap;

    @Autowired
    private RoomService roomSrv;
    @Autowired
    private RoomMapper roomMap;

    private List<HotelRoomPrice> getAll(Integer pageNr, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return hotelRoomPriceRep.findAll(pageable).toList();
    }

    private List<HotelRoomPrice> getByHotel
            (Integer pageNr, Integer pageSize, Long hotelId) throws TravelAgencyException {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        HotelDto hotelDto = hotelSrv.getById(hotelId);
        return hotelRoomPriceRep.findAllByHotel(hotelMap.dtoToModel(hotelDto));
    }

    private List<HotelRoomPrice> getByRoom
            (Integer pageNr, Integer pageSize, Long roomId) throws TravelAgencyException {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        RoomDto roomDto = roomSrv.getById(roomId);
        return hotelRoomPriceRep.findAllByRoom(roomMap.dtoToModel(roomDto));
    }

    public List<HotelRoomPriceDto> get
            (Integer pageNr, Integer pageSize, Long hotelId, Long roomId) throws TravelAgencyException {
        List<HotelRoomPrice> hotelRoomPrices;

        if (hotelId == null && roomId == null) hotelRoomPrices = getAll(pageNr, pageSize);
        else if (hotelId == null) hotelRoomPrices = getByRoom(pageNr, pageSize, roomId);
        else if (roomId == null) hotelRoomPrices = getByHotel(pageNr, pageSize, hotelId);
        else throw new HotelRoomPriceMeaninglessSearchException();

        if (hotelRoomPrices.size() == 0) throw new HotelRoomPricesNotFoundException();

        return hotelRoomPrices.stream()
                .map(hotelRoomPrice -> hotelRoomPriceMap.modelToDto(hotelRoomPrice))
                .collect(Collectors.toList());
    }
}
