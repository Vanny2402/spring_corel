package com.jv.crud_operation.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.AccountEntity;
import com.jv.crud_operation.model.entity.response.account.AccountResponse;
import com.jv.crud_operation.model.entity.response.infra.BaseBodyResponse;
import com.jv.crud_operation.model.entity.response.infra.BaseResponse;
import com.jv.crud_operation.model.entity.reuest.RestoerCategoryRequest;
import com.jv.crud_operation.model.entity.reuest.account.AccountRequest;
import com.jv.crud_operation.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Backend A Contrlller", description = "Contrller for admin account")
@RestController
@RequestMapping("account")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@Operation(summary = "Create account!", description = "Admin craete account", responses = {
			@ApiResponse(responseCode = "201", description = "Create Success", content = @Content(schema = @Schema(implementation = AccountResponse.class), mediaType = "application/json")),
			@ApiResponse(responseCode = "400-500", description = "Error", content = @Content(schema = @Schema(implementation = AccountResponse.class), mediaType = "application/json")) })
	@PostMapping("")
	public ResponseEntity<BaseBodyResponse> creat(@Valid @RequestBody AccountRequest request) throws Exception {
		AccountEntity account = this.accountService.create(request);
		return BaseBodyResponse.createsuccess(AccountResponse.fromEntity(account), "Succcess Created!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<BaseBodyResponse> update(@PathVariable Long id, @RequestBody AccountRequest request)
			throws Exception {
		AccountEntity account = this.accountService.update(id, request);
		return BaseBodyResponse.success(AccountResponse.fromEntity(account), "Updated Success!");
	}

	@GetMapping("")
	public ResponseEntity<BaseBodyResponse> findAll(
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int page,
			@RequestParam(name = "limit", required = true, defaultValue = "3") int limit,
			@RequestParam(name = "isPage", required = false, defaultValue = "true") Boolean isPage,
			@RequestParam(name = "sort", required = false, defaultValue = "id:desc") String sort,
			@RequestParam(name = "isTrash", required = false, defaultValue = "false") Boolean isTrash,
			@RequestParam Map<String, String> reqParam_serch) throws Exception {
		Page<BaseResponse> account = this.accountService.findAll(page, limit, isPage, sort, isTrash, reqParam_serch)
				.map(AccountResponse::fromEntity);
		return BaseBodyResponse.success(account, "success");
	}

	@Operation(summary = "Hello Brother I love you !", description = "Hi Brother!", responses = {
			@ApiResponse(responseCode = "200", description = "Success Man", content = @Content(schema = @Schema(implementation = AccountResponse.class), mediaType = "application/json")) })
	@GetMapping("/{id}")
	public ResponseEntity<AccountResponse> findOne(@PathVariable Long id) throws NotFoundException {
		AccountEntity account = this.accountService.findOne(id);
		return ResponseEntity.ok(AccountResponse.fromEntity(account));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<AccountResponse> delete(@PathVariable Long id) throws Exception {
		AccountEntity account = accountService.delete(id);
		return ResponseEntity.ok(AccountResponse.fromEntity(account));
	}

	@Operation(summary = "Hello Brother this is function to resoter!", description = "Hi Restore!", responses = {
			@ApiResponse(responseCode = "200", description = "Success Man", content = @Content(schema = @Schema(implementation = AccountResponse.class), mediaType = "application/json")) })
	@PutMapping("/restore/{id}")
	public ResponseEntity<BaseBodyResponse> restore(@PathVariable Long id,@Valid @RequestBody RestoerCategoryRequest req)
			throws Exception {
		AccountEntity account = this.accountService.restore(id, req);
		return BaseBodyResponse.success(AccountResponse.fromEntity(account), "Restored Success!");
	}

}
