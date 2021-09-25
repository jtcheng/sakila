package com.ibm.jtcheng.sakila.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Builder.Default
	private LocalDateTime timestamp = LocalDateTime.now();

	private String path;
	private int status;
	private String error;

	@JsonInclude(value = Include.NON_EMPTY)
	@Builder.Default
	private List<T> details = new ArrayList<>();

}
