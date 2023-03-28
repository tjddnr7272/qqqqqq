package ezen.springmvc.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {
	/**
	 * GET /users
	 */
	@GetMapping
	public String users() {
		return "get users";
	}

	/**
	 * POST /users
	 */
	@PostMapping
	public String registerUser() {
		return "post user";
	}

	/**
	 * GET /users/{userId}
	 */
	@GetMapping("/{userId}")
	public String findUser(@PathVariable String userId) {
		return "get userId=" + userId;
	}

	/**
	 * PATCH /users/{userId}
	 */
	@PatchMapping("/{userId}")
	public String updateUser(@PathVariable String userId) {
		return "update userId=" + userId;
	}

	/**
	 * DELETE /users/{userId}
	 */
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable String userId) {
		return "delete userId=" + userId;
	}
}