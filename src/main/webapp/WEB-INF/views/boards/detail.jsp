<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<br /> <br />
	<div>
		<h3 >${boards.title }</h3>
	</div>
	<hr/>

	<div >${boards.content }</div>

	<button>수정하기</button>
	<button>삭제하기</button>
</div>

<%@ include file="../layout/footer.jsp"%>

