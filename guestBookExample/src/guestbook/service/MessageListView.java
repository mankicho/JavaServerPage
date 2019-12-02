package guestbook.service;

import guestbook.model.Message;

import java.util.List;

public class MessageListView {
    private int messageTotalCount; // 메세지 총 개수
    private int currentPageNumber; // 현재 페이지 넘버
    private List<Message> messageList; // 메세지 리스트
    private int pageTotalCount; // 페이지 총 개수
    private int messageCountPerPage; // 페이지 당 메세지 수
    private int firstRow; // 첫번째 줄
    private int endRow; // 마지막 줄

    // 생성자
    public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList, int messageCountPerPage, int firstRow, int endRow) {
        this.messageTotalCount = messageTotalCount;
        this.currentPageNumber = currentPageNumber;
        this.messageList = messageList;
        this.messageCountPerPage = messageCountPerPage;
        this.firstRow = firstRow;
        this.endRow = endRow;
        calculatePageTotalCount();
    }

    // 페이지 총 개수 구하기
    private void calculatePageTotalCount() {
        if (messageTotalCount == 0) {
            pageTotalCount = 0;
        } else {
            pageTotalCount = messageTotalCount / messageCountPerPage;
            if (messageTotalCount % messageCountPerPage > 0) {
                pageTotalCount++;
            }
        }
    }

    public int getMessageTotalCount() {
        return messageTotalCount;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public int getMessageCountPerPage() {
        return messageCountPerPage;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public boolean isEmpty() {
        return messageTotalCount == 0;
    }
}
