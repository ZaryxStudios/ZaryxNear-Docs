package dev.zaryxstudios.zaryxnear.grpc;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.CategoryTreeResponse;
import dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocGrpc;
import dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocRequestProto;
import dev.zaryxstudios.zaryxnear.ai.context.docs.community.config.DocResponseProto;
import dev.zaryxstudios.zaryxnear.dto.DocResponse;
import dev.zaryxstudios.zaryxnear.proto.*;
import dev.zaryxstudios.zaryxnear.service.DocsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrpcDocService extends DocGrpc.DocImplBase {

    private final DocsService docsService;

    @Override
    public void getDocInformation(
            DocRequestProto request,
            StreamObserver<DocResponseProto> responseObserver
    ) {
        String fullCategory = request.getCategory() + "/" + request.getSubcategory();
        DocResponse doc = docsService.getDoc(fullCategory, request.getDocId());

        DocResponseProto.Builder docResponseBuilder = DocResponseProto.newBuilder();

        if (doc == null) {
            docResponseBuilder
                    .setContent("")
                    .setTokens(0);
        } else {
            docResponseBuilder
                    .setContent(doc.content())
                    .setTokens(doc.tokens());
        }

        responseObserver.onNext(docResponseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCategoryTree(
            Empty request,
            StreamObserver<CategoryTreeResponse> responseObserver
    ) {
        CategoryTreeResponse.Builder categoryTreeResponseBuilder = CategoryTreeResponse.newBuilder();

        categoryTreeResponseBuilder
                .putAllCategoryTree(docsService.getCategoryTreeProto());

        responseObserver.onNext(categoryTreeResponseBuilder.build());
        responseObserver.onCompleted();
    }
}
